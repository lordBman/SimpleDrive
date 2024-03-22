package com.bsoft.simpledrive.repository;

import com.bsoft.simpledrive.models.File;
import org.springframework.data.repository.CrudRepository;

public interface FilesRepository extends CrudRepository<File, Integer> {

}
