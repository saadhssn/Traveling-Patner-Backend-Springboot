package com.internode_studios.spring_boot_application.banner.service;

import com.internode_studios.spring_boot_application.banner.model.Banner;
import com.internode_studios.spring_boot_application.banner.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    // Create a new Banner
    public Banner createBanner(Banner banner) {
        return bannerRepository.save(banner);
    }

    // Get all Banner
    public List<Banner> getAllBanners() {
        return bannerRepository.findAll();
    }

    // Get Banner by ID
    public Optional<Banner> getBannerById(Long id) {
        return bannerRepository.findById(id);
    }

    // Update Banner by ID
    public Banner updateBanner(Long id, Banner updatedBanner) {
        return bannerRepository.findById(id).map(existingBanner -> {
            // Update only the non-null fields
            if (updatedBanner.getBannerImage() != null) {
                existingBanner.setBannerImage(updatedBanner.getBannerImage());
            }
            if (updatedBanner.getBannerTitle() != null) {
                existingBanner.setBannerTitle(updatedBanner.getBannerTitle());
            }
            if (updatedBanner.getBannerDescription() != null) {
                existingBanner.setBannerDescription(updatedBanner.getBannerDescription());
            }
            return bannerRepository.save(existingBanner);
        }).orElseThrow(() -> new RuntimeException("Banner not found"));
    }


    // Delete Banner by ID
    public void deleteBanner(Long id) {
        bannerRepository.deleteById(id);
    }
}
