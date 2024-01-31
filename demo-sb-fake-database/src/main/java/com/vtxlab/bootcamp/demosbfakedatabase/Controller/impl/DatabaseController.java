package com.vtxlab.bootcamp.demosbfakedatabase.Controller.impl;

import com.vtxlab.bootcamp.demosbfakedatabase.Controller.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.demosbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.demosbfakedatabase.Service.CatDatabaseService;

// @Controller
// @ResponseBody // JSON
@RestController // (@Controller + @ResponseBody)
// Create an object of this class, and put it into Spring context
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  @Autowired // dependency injection
  private CatDatabaseService catDatabaseService;

  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    catDatabaseService.setCatToStaticMemory(index,
        new Cat(name, age));
  }

  @Override
  public Boolean createCat(int index, Cat cat) {
    return catDatabaseService.createCatInStaticMemory(index, cat);
  }

  @Override
  public Boolean deleteCat(int index) {
    return catDatabaseService.deleteCatFromStaticMemory(index);
  }

  @Override
  public Boolean updateCat(int index, Cat cat) {
    return catDatabaseService.updateCatInStaticMemory(index, cat);
  }

  @Override
  public void patchCatName(int index, String name) {
    catDatabaseService.patchCatNameInStaticMemory(index, name);
  }

  @Override
  public void patchCatAge(int index, int age) {
    catDatabaseService.patchCatAgeInStaticMemory(index, age);
  }

}
