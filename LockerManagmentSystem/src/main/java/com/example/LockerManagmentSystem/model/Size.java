package com.example.LockerManagmentSystem.model;


import lombok.Data;
import lombok.Getter;
@Getter
public class Size  {
   private  String sizeId;
   private Integer length;
   private Integer breadth;

    public Size(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public boolean canAccomidate(Size size)
   {
       int area=this.breadth*this.length;
       int area2=size.breadth*size.length;
       if(area>area2) return true;
       return false;
   }
}
