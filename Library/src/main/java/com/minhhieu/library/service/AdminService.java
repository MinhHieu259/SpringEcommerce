package com.minhhieu.library.service;

import com.minhhieu.library.dto.AdminDto;
import com.minhhieu.library.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
