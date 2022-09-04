package controller;

import model.Writer;
import repository.implementation.WriterRepositoryImpl;

import java.util.List;

public class WriterController {
    WriterRepositoryImpl repository = new WriterRepositoryImpl();
    public Writer create(Writer writer) {
        return repository.create(writer);
    }
    public List<Writer> getAll() {
        return repository.getAll();
    }
    public Writer getById(Long id) {
        return repository.getById(id);
    }
    public Writer update(Writer writer) {
        return repository.update(writer);
    }
    public void remove(Long id) {
        repository.remove(id);
    }
}
