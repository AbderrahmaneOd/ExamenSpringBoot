package com.ouaday.services;

import com.ouaday.dao.IDao;
import com.ouaday.entities.Employe;
import com.ouaday.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService implements IDao<Employe> {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe create(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public boolean delete(Employe o) {
        try {
            employeRepository.delete(o);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Employe update(Employe o) {
        return employeRepository.save(o);
    }

    @Override
    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    @Override
    public Employe findById(long id) {
        return employeRepository.findById(id).orElse(null);
    }


}
