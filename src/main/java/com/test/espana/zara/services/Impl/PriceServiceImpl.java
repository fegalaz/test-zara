package com.test.espana.zara.services.Impl;

import com.test.espana.zara.dto.PricesDTO;
import com.test.espana.zara.exceptions.ClientConnectionErrorException;
import com.test.espana.zara.mapper.PriceMapper;
import com.test.espana.zara.repository.PricesRepository;
import com.test.espana.zara.repository.entity.Prices;
import com.test.espana.zara.services.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private PriceMapper mapper;

    /**
     *Metodo que obtiene la lista completa
     * de precios
     * @return
     */
    public List<PricesDTO> getPrices() {

        try {
            log.info("Call to pricesRepository.findAll()");
            List<Prices> responds = pricesRepository.findAll();
            return responds.stream().map(mapper::entityToDTO).collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Repository connection error", e);
            throw new ClientConnectionErrorException("Repository connection error", e);
        }
    }


    /**
     * Metodo que obtiene la lista de precios
     * dado los siguientes parametros
     * @param entryDate
     * @param productId
     * @param brandId
     * @return
     */
    public List<PricesDTO> getPricesWithFilter(LocalDateTime entryDate, int productId, int brandId) {

        try {
            log.info("Call to pricesRepository.findByProductIdAndBrandId()");
            final List<Prices> firstList = pricesRepository.findByProductIdAndBrandId(productId, brandId);
            final List<Prices> secondList = new ArrayList<>();
            final List<Prices> thirdList = new ArrayList<>();

            firstList.forEach(s -> {
                /**
                 * First validate if the entryDate is between startDate and EndDate
                 * fecha enetrada > fecha entrada < fecha de fin
                 */
                if (entryDate.isBefore(s.getEndDate()) && entryDate.isAfter(s.getStartDate())) {
                    secondList.add(s);
                }
            });

            Prices pricePriority = secondList.stream()
                    .collect(Collectors.maxBy(Comparator.comparingInt(Prices::getPriority)))
                    .get();

            thirdList.add(pricePriority);

            return thirdList.stream().map(mapper::entityToDTO).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Repository connection error", e);
            throw new ClientConnectionErrorException("Repository connection error", e);
        }
    }
}