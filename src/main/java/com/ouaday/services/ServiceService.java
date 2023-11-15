package com.ouaday.services;

import com.ouaday.dao.IDao;
import com.ouaday.entities.Service;
import com.ouaday.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service create(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public boolean delete(Service o) {
        try {
            serviceRepository.delete(o);
            return true;
        }
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public Service update(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
