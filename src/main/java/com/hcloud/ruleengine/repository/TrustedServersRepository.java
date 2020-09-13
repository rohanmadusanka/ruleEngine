package com.hcloud.ruleengine.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcloud.ruleengine.model.TrustedServerZone;

public interface TrustedServersRepository extends JpaRepository<TrustedServerZone, Long>{

	@Query("select c from trustedservers c")
	Page<TrustedServerZone> findAllPage(Pageable pageable);

	@Query("select c from trustedservers c")
	Slice<TrustedServerZone> findAllSlice(Pageable pageable);

	@Query("select c from trustedservers c")
	List<TrustedServerZone> findAllSorted(Sort sort);

//	Page<TrustedServerZone> findByMovie(String movieName, Pageable pageable);
//
//	@Query("select c from trustedservers c where c.movie = :movie")
//	Slice<TrustedServerZone> findByMovieCustom(
//			@Param("movie") String movieName, Pageable pageable);
//
//	@Query("select c from trustedservers c where c.movie = :movie")
//	List<TrustedServerZone> findByMovieSorted(
//			@Param("movie") String movieName, Sort sort);
}
