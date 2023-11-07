package com.skyscanner.Resources;

import com.skyscanner.models.Search;
import com.skyscanner.models.SearchResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {

    List<SearchResult> searchResults;

    // Constructor that allows injection of searchResults to the class
    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    //Handles the POST request returning search results that match the search query in the request
    @POST
    public List<SearchResult> search(@NotNull @Valid Search search){
        List<SearchResult> response = new ArrayList<>();
        for (SearchResult result : searchResults){
            if (result.getCity().equals(search.getCity())) {
                response.add(result);
            }
        }
        return response;
    }

}
