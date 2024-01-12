package com.github.wglanzer.reproducer;

import io.quarkus.cache.CacheResult;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * @author w.glanzer, 12.01.2024
 */
@ApplicationScoped
public class DemoApp
{

  @CacheResult(cacheName = "demo")
  public String run()
  {
    return "cache" + System.currentTimeMillis();
  }

  @Startup
  public void start()
  {
    System.out.println(run());
    System.out.println(run());
    System.out.println(run());
  }

}
