package softuni.softuni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.softuni.dtos.bindings.LensImportFromJsonDto;
import softuni.softuni.entities.Lens;
import softuni.softuni.repositories.LensRepository;
import softuni.softuni.utilities.MapperConverter;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class LensServiceImpl implements LensService {

    private final LensRepository lensRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public LensServiceImpl(LensRepository lensRepository, MapperConverter mapperConverter) {
        this.lensRepository = lensRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public List<Lens> findAll() {
        return this.lensRepository.findAll();
    }

    @Override
    public Lens findById(long id) {
        return this.lensRepository.findOne(id);
    }

    @Override
    public Lens createOne(Lens lens) {
        return this.lensRepository.save(lens);
    }

    @Override
    public List<Lens> createMany(Iterable<LensImportFromJsonDto> lensImportDtos) {
        Lens[] lenses = this.mapperConverter.convert(lensImportDtos, Lens[].class);
        return this.lensRepository.save(Arrays.asList(lenses));
    }

    @Override
    public Lens updateOne(Lens lens) {
        return this.lensRepository.save(lens);
    }

    @Override
    public List<Lens> updateMany(Iterable<Lens> lenss) {
        return this.lensRepository.save(lenss);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.lensRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByLens(Lens lens) {
        this.lensRepository.delete(lens);
    }

    @Override
    public long countByLensOwnerId(long lensOwnerId) {
        return this.lensRepository.countByLensOwnerId(lensOwnerId);
    }

}