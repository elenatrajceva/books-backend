package mk.ukim.finki.booksbackend.service;

import mk.ukim.finki.booksbackend.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
}
