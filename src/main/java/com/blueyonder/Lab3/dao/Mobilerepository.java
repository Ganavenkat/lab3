package com.blueyonder.Lab3.dao;

import com.blueyonder.Lab3.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Mobilerepository extends JpaRepository<Mobile,Integer> {
}
