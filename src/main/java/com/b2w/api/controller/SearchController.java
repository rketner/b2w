package com.b2w.api.controller;

import com.b2w.api.controller.response.Search;
import com.b2w.api.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rketner
 */
@Slf4j
@Validated
@RestController
@Api(value = "Search")
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @ResponseBody
    @ApiOperation(value = "search")
    @GetMapping(value = "/{word}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Search> getSearch(@PathVariable("word") String word) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(searchService.search(word));
    }

}
