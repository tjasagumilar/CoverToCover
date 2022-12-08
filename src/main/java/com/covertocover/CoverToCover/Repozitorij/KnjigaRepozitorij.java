package com.covertocover.CoverToCover.Repozitorij;

import com.covertocover.CoverToCover.Modeli.Knjiga;

public interface KnjigaRepozitorij {
    Iterable<Knjiga> findAll();
}
