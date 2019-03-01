package br.com.locadora.resource;

import br.com.locadora.domain.out.MovieDomainOut;
import br.com.locadora.facade.MovieFacade;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/movie")
public class MovieResource {

    public final MovieFacade movieFacade;

    @Autowired
    public MovieResource(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping
    @ApiOperation(value = "Listagem de filmes disponíveis", response = MovieDomainOut[].class)
    public ResponseEntity<List<MovieDomainOut>> findAll() {
        return ResponseEntity.ok(movieFacade.findAll());
    }

    @GetMapping("/{title}")
    @ApiOperation(value = "Listagem de filmes pelo título", response = MovieDomainOut[].class)
    public ResponseEntity<List<MovieDomainOut>> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(movieFacade.findByTitle(title));
    }
}
