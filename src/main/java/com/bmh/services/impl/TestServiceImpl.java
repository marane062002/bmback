package com.bmh.services.impl;

import com.bmh.beans.TestDTO;
import com.bmh.services.ITestService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements ITestService {

    @Override
    public TestDTO save(TestDTO paramT) {
        return null;
    }

    @Override
    public TestDTO update(Long paramLong, TestDTO paramT) {
        return null;
    }

    @Override
    public List<TestDTO> all() {
        return null;
    }

    @Override
    public void delete(Long paramLong) {

    }

    @Override
    public TestDTO findById(Long paramLong) {
        return null;
    }
}
