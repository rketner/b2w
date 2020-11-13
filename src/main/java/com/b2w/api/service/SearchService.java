package com.b2w.api.service;

import com.b2w.api.controller.response.Search;
import com.b2w.api.exception.InternalServerErrorException;
import com.b2w.api.exception.NotFoundException;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author rketner
 */
@Slf4j
@Service
public class SearchService {

    private static final String[] FILES 
            = {"words_1", "words_2", "words_3", "words_4", "words_5", "words_6", "words_7"};
    private static final String REGEX_FIX_CHAR_SPECIAL = "[^\\x20-\\x7e]";

    public Search search(String wordSearh) {
        Search s = new Search();
        long startTime = System.nanoTime();
        int countOccurs = 0;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            for (String FILES1 : FILES) {
                String fileCsv = FILES1 + ".csv";
                log.info("Lendo arquivo = " + fileCsv);
                File file = new File(classLoader.getResource(fileCsv).getFile());
                FileReader filereader = new FileReader(file.getAbsolutePath());
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (String cell : nextRecord) {
                        String word = cell.replaceAll(REGEX_FIX_CHAR_SPECIAL, "");
                        if (word.contains(wordSearh)) {
                            countOccurs++;
                        }
                    }
                }
                s.setOccurs(countOccurs);
                s.setTimed(String.format("Executado em: %d milliseconds", System.nanoTime() - startTime));
            }
        } catch (FileNotFoundException ex) {
            log.error("Arquivo não encontrado", ex);
            throw new NotFoundException("Arquivo não encontrado");
        } catch (IOException ex) {
            log.error("Erro ao ler arquivo", ex);
            throw new InternalServerErrorException("Erro ao ler arquivo");
        } 
        return s;
    }

}
