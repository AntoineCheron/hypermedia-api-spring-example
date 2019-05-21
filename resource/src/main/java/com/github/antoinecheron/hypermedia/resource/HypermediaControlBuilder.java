package com.github.antoinecheron.hypermedia.resource;

import org.springframework.hateoas.Link;
import reactor.core.publisher.Mono;

public interface HypermediaControlBuilder<T> {

  String getRelation();

  Mono<Link> build(T resource);

}
