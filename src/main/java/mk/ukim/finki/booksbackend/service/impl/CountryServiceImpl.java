package mk.ukim.finki.booksbackend.service.impl;

import mk.ukim.finki.booksbackend.model.Country;
import mk.ukim.finki.booksbackend.repository.CountryRepository;
import mk.ukim.finki.booksbackend.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}
