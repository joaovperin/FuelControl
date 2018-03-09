/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jpe.fuelcontrol.services;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

/**
 * Generate ADs :D
 *
 * @author joaovperin
 */
@Service
public class AdvertisementGeneratorService {

    /**
     * Generates (query) a randomAd
     *
     * @return String
     */
    public String randomAd() {
        try {
            // Request to FreeMarket.
            Document doc = Jsoup.connect("https://www.mercadolivre.com.br/").get();
            // Recommendations section
            Element sectionRecommendations = doc.select("section.recommendations").first();
            // ADs
            StringBuilder sb = new StringBuilder(1024);
            sb.append(doc.title()).append("\n");
            sb.append("Confira as ofertas que estão bombando na sua cidade!!").append("\n\n\n");
            // Each element
            sectionRecommendations.select("div.slick-slide.slick-active").stream().forEach((e) -> {
                Element link = e.select("a[href]").first();
                sb.append(link.text()).append('\n').append(link.attr("href")).append("\n\n");
            });
            return sb.append("\n").toString();
        } catch (IOException e) {
            return "randomAd";
        }
    }

}
