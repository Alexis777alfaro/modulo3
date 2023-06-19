package com.moduloIII.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moduloIII.Repository.ComputersRepository;
import com.moduloIII.Repository.SequenceRepository;
import com.moduloIII.collections.Computers;
import com.moduloIII.collections.Sequence;

@Service
public class ComputersService {
    @Autowired
    private ComputersRepository computersRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

    public List<Computers> getAll() {
        return computersRepository.findAll();
    }

    public Computers getById(String id) {
        return computersRepository.findById(id).orElse(null);
    }

    public Computers create(Computers computer) {
        Long sequence = generateSequence();
        computer.setSequence(sequence);
        return computersRepository.save(computer);
    }

    public Computers update(Computers computer) {
        return computersRepository.save(computer);
    }

    public void delete(String id) {
        computersRepository.deleteById(id);
    }

    private synchronized Long generateSequence() {
        Sequence sequence = sequenceRepository.findById("computers").orElse(null);
        if (sequence == null) {
            sequence = new Sequence();
            sequence.setId("computers");
            sequence.setSeq(1L);
        } else {
            sequence.setSeq(sequence.getSeq() + 1);
        }
        sequenceRepository.save(sequence);
        return sequence.getSeq();
    }
}
