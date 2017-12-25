package com.vm.client.models.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBee extends ModelBase
{
  //fields
    ModelRenderer ASS;
    ModelRenderer Eye1;
    ModelRenderer Wing1;
    ModelRenderer Face;
    ModelRenderer Eye2;
    ModelRenderer Leg1;
    ModelRenderer Wing2;
    ModelRenderer Body;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Leg5;
    ModelRenderer Leg6;
  
  public ModelBee()
  {
    textureWidth = 20;
    textureHeight = 10;
    
      ASS = new ModelRenderer(this, 0, 5);
      ASS.addBox(-1F, 0F, 0F, 2, 2, 3);
      ASS.setRotationPoint(0F, 22F, 0F);
      ASS.setTextureSize(20, 10);
      ASS.mirror = true;
      setRotation(ASS, -0.1745329F, 0F, 0F);
      Eye1 = new ModelRenderer(this, 16, 0);
      Eye1.addBox(0.2F, 0.2F, -3.6F, 1, 1, 1);
      Eye1.setRotationPoint(0F, 23F, 0F);
      Eye1.setTextureSize(20, 10);
      Eye1.mirror = true;
      setRotation(Eye1, -0.2792527F, 0F, 0F);
      Wing1 = new ModelRenderer(this, 10, 4);
      Wing1.addBox(0.5F, -2F, -2F, 1, 0, 3);
      Wing1.setRotationPoint(0F, 23F, 0F);
      Wing1.setTextureSize(20, 10);
      Wing1.mirror = true;
      setRotation(Wing1, 0.4537856F, 0.1745329F, 0F);
      Face = new ModelRenderer(this, 10, 1);
      Face.addBox(-1F, 0F, -3.5F, 2, 2, 1);
      Face.setRotationPoint(0F, 23F, 0F);
      Face.setTextureSize(20, 10);
      Face.mirror = true;
      setRotation(Face, -0.2792527F, 0F, 0F);
      Eye2 = new ModelRenderer(this, 16, 0);
      Eye2.addBox(-1.2F, 0.2F, -3.6F, 1, 1, 1);
      Eye2.setRotationPoint(0F, 23F, 0F);
      Eye2.setTextureSize(20, 10);
      Eye2.mirror = true;
      setRotation(Eye2, -0.2792527F, 0F, 0F);
      Leg1 = new ModelRenderer(this, 10, 0);
      Leg1.addBox(-2.5F, 0F, 0F, 2, 0, 1);
      Leg1.setRotationPoint(0F, 23F, 0F);
      Leg1.setTextureSize(20, 10);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, -0.6108652F);
      Wing2 = new ModelRenderer(this, 10, 4);
      Wing2.addBox(-1.5F, -2F, -2F, 1, 0, 3);
      Wing2.setRotationPoint(0F, 23F, 0F);
      Wing2.setTextureSize(20, 10);
      Wing2.mirror = true;
      setRotation(Wing2, 0.4537856F, -0.1745329F, 0F);
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-1F, -1F, -3F, 2, 2, 3);
      Body.setRotationPoint(0F, 23F, 0F);
      Body.setTextureSize(20, 10);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 10, 0);
      Leg2.addBox(-2.5F, 0F, -3F, 2, 0, 1);
      Leg2.setRotationPoint(0F, 23F, 0F);
      Leg2.setTextureSize(20, 10);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, -0.6108652F);
    //  Leg3.mirror = false;
      Leg3 = new ModelRenderer(this, 10, 0);
      Leg3.addBox(0.5F, 0F, -3F, 2, 0, 1);
      Leg3.setRotationPoint(0F, 23F, 0F);
      Leg3.setTextureSize(20, 10);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0.6108652F);
      Leg3.mirror = false;
    //  Leg4.mirror = true;
      Leg4 = new ModelRenderer(this, 10, 0);
      Leg4.addBox(0.5F, 0F, 0F, 2, 0, 1);
      Leg4.setRotationPoint(0F, 23F, 0F);
      Leg4.setTextureSize(20, 10);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0.6108652F);
      Leg4.mirror = false;
    //  Leg5.mirror = true;
      Leg5 = new ModelRenderer(this, 10, 0);
      Leg5.addBox(0.5F, 0F, -1.5F, 2, 0, 1);
      Leg5.setRotationPoint(0F, 23F, 0F);
      Leg5.setTextureSize(20, 10);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, 0F, 0.6108652F);
      Leg5.mirror = false;
      Leg6 = new ModelRenderer(this, 10, 0);
      Leg6.addBox(-2.5F, 0F, -1.5F, 2, 0, 1);
      Leg6.setRotationPoint(0F, 23F, 0F);
      Leg6.setTextureSize(20, 10);
      Leg6.mirror = true;
      setRotation(Leg6, 0F, 0F, -0.6108652F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    ASS.render(f5);
    Eye1.render(f5);
    Wing1.render(f5);
    Face.render(f5);
    Eye2.render(f5);
    Leg1.render(f5);
    Wing2.render(f5);
    Body.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Leg5.render(f5);
    Leg6.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }


}
