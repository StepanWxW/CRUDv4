package controller;

import model.Region;
import repository.implementation.RegionRepositoryImpl;

import java.util.List;

public class RegionController {
    private final RegionRepositoryImpl repository = new RegionRepositoryImpl();
    public Region create(Region region) {
        return repository.create(region);
    }
    public List<Region> getAll() {
        return repository.getAll();
    }
    public Region getById(Long id) {
        return repository.getById(id);
    }
    public Region update(Region region) {
        return repository.update(region);
    }
    public void remove(Long id) {
        repository.remove(id);
    }
}
