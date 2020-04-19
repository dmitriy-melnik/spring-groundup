package com.sulevsky.service;

import com.sulevsky.model.Worker;
import com.sulevsky.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerServiceImpl implements WorkerService {

    private IdGenerator idGenerator = new IdGenertorImpl();
    @Autowired
    private WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(String firstName, String lastName) {
        String id = idGenerator.generateId();

        Worker worker = new Worker(id, firstName, lastName);

        workerRepository.save(worker);
        return worker;
    }

    @Override
    public Worker findWorkerByFirstNameAndLastName(String firstName, String lastName) {
        List<Worker> workers = workerRepository.findAll();
        return workers
                .stream()
                .filter(worker -> worker.getFirstName().equals(firstName)
                        && worker.getLastName().equals(lastName))
                .findFirst()
                .get();
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }
}
