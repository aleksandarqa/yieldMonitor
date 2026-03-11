package org.example.yieldmonitor.controller;

import org.example.yieldmonitor.model.ManualTest;
import org.example.yieldmonitor.repository.ManualTestRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class TestController {

    private final ManualTestRepository manualTestRepository;

    public TestController(ManualTestRepository manualTestRepository) {
        this.manualTestRepository = manualTestRepository;
    }

    @PostMapping("/tests")
    public ManualTest addTest(@RequestBody ManualTest manualTest) {
        return manualTestRepository.save(manualTest);
    }

    @GetMapping("/tests")
    public List<ManualTest> getAllTests() {
        return manualTestRepository.findAll();
    }

    @GetMapping("/stats")
    public List<Map<String, Object>> getStats() {
        List<ManualTest> tests = manualTestRepository.findAll();

        Map<String, List<ManualTest>> grouped = tests.stream()
                .collect(Collectors.groupingBy(ManualTest::getPartNumber));

        List<Map<String, Object>> result = new ArrayList<>();

        for (Map.Entry<String, List<ManualTest>> entry : grouped.entrySet()) {
            String partNumber = entry.getKey();
            List<ManualTest> partTests = entry.getValue();

            long total = partTests.size();
            long passed = partTests.stream().filter(t -> Boolean.TRUE.equals(t.getStatus())).count();
            double yield = total == 0 ? 0 : (passed * 100.0) / total;

            Map<String, Object> row = new HashMap<>();
            row.put("partNumber", partNumber);
            row.put("total", total);
            row.put("passed", passed);
            row.put("failed", total - passed);
            row.put("yield", yield);

            result.add(row);
        }

        return result;
    }

    @GetMapping("/daily")
    public List<Map<String, Object>> getDailyStats() {
        List<ManualTest> tests = manualTestRepository.findAll();

        Map<LocalDate, Long> counts = tests.stream()
                .collect(Collectors.groupingBy(
                        t -> t.getTimestamp().toLocalDate(),
                        Collectors.counting()
                ));

        List<Map<String, Object>> result = new ArrayList<>();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = LocalDate.now().minusDays(i);

            Map<String, Object> row = new HashMap<>();
            row.put("date", date.toString());
            row.put("count", counts.getOrDefault(date, 0L));

            result.add(row);
        }

        return result;
    }
}