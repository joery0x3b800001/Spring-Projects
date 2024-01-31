package com.springframework.quoters;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepostory extends JpaRepository<Quote, Long> {
}
