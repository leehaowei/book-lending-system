package com.leehaowei.booklendingsystem.borrowingrecord;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class BorrowingRecordController {

    private final BorrowingRecordService recordService;

    public BorrowingRecordController(BorrowingRecordService recordService) {

        this.recordService = recordService;
    }

    @GetMapping
    public List<BorrowingRecord> getAllRecords() {
        return recordService.getAllRecords();
    }

    @PostMapping("borrow")
    public void createRecords(
            @RequestBody BorrowBookRequest request) {
        recordService.addRecord(request);

    }
}
