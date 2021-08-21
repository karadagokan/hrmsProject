package com.karadag.hrmsProject.business.abstracts;

import com.karadag.hrmsProject.core.utilities.DataResult;
import com.karadag.hrmsProject.core.utilities.Result;
import com.karadag.hrmsProject.entities.concretes.SystemEmployee;

import java.util.List;

public interface SystemEmployeeService {

    DataResult<List<SystemEmployee>> getAll();

    Result addSystemEmployee(SystemEmployee employee);
}
