package com.itssub.common.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIFollowOwnerFlying;
import net.minecraft.entity.ai.EntityAILandOnOwnersShoulder;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBee extends EntityAnimal implements EntityFlying
{

    private BlockPos boundOrigin;
	

	public EntityBee(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F, 0.8F);
        this.moveHelper = new EntityFlyHelper(this);
    } 
	
	
	@Override
	public void travel(float p_191986_1_, float p_191986_2_, float p_191986_3_)
    {
        if (this.isInWater())
        {
            this.moveRelative(p_191986_1_, p_191986_2_, p_191986_3_, 0.02F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
        }
        else if (this.isInLava())
        {
            this.moveRelative(p_191986_1_, p_191986_2_, p_191986_3_, 0.02F);
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
        }
        else
        {
            float f = 0.91F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            float f1 = 0.16277136F / (f * f * f);
            this.moveRelative(p_191986_1_, p_191986_2_, p_191986_3_, this.onGround ? 0.1F * f1 : 0.02F);
            f = 0.91F;

            if (this.onGround)
            {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                IBlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= (double)f;
            this.motionY *= (double)f;
            this.motionZ *= (double)f;
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }


    @Override
    protected void initEntityAI()
    {
    	 super.initEntityAI();
        this.tasks.addTask(0, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.moveHelper = new EntityBee.AIMoveControl(this);
        this.tasks.addTask(8, new EntityBee.AIMoveRandom()); 
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
         this.tasks.addTask(3, new EntityAIFollow(this, 1.0D, 3.0F, 7.0F));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4000000059604645D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
    }

    
    public void updateTask()
    {
        EntityLivingBase entitylivingbase = EntityBee.this.getAttackTarget();

        if (EntityBee.this.getEntityBoundingBox().intersects(entitylivingbase.getEntityBoundingBox()))
        {
            EntityBee.this.attackEntityAsMob(entitylivingbase);;
        }
        else
        {
            double d0 = EntityBee.this.getDistance(entitylivingbase);

            if (d0 < 9.0D)
            {
                Vec3d vec3d = entitylivingbase.getPositionEyes(1.0F);
                EntityBee.this.moveHelper.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
            }
        }
    }

    
    
    @Override
    protected PathNavigate createNavigator(World worldIn)
    {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

    @Override
    public float getEyeHeight()
    {
        return this.height * 0.6F;
    }


    @Override
    public void onLivingUpdate()
    {	
        super.onLivingUpdate();
    } 

    @Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getEntityBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        Block block = this.world.getBlockState(blockpos.down()).getBlock();
        return block instanceof BlockLeaves || block == Blocks.GRASS || block instanceof BlockLog || block == Blocks.AIR && this.world.getLight(blockpos) > 8 && super.getCanSpawnHere();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F);
    }
    
    @Nullable
    public BlockPos getBoundOrigin()
    {
        return this.boundOrigin;
    }
    

    @Override
    public boolean canBePushed()
    {
        return true;
    }

    protected void collideWithEntity(Entity entityIn)
    {
        if (entityIn instanceof EntityPlayer)
        {
        	if(entityIn.getName() == "SubPai") {
        		
        		
        	}
            super.collideWithEntity(entityIn);
        }
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  class AIMoveRandom extends EntityAIBase
	    {
	        public AIMoveRandom()
	        {
	            this.setMutexBits(1);
	        }

	        /**
	         * Returns whether the EntityAIBase should begin execution.
	         */
	        public boolean shouldExecute()
	        {
	            return !EntityBee.this.getMoveHelper().isUpdating() && EntityBee.this.rand.nextInt(7) == 0;
	        }

	        /**
	         * Returns whether an in-progress EntityAIBase should continue executing
	         */
	        public boolean shouldContinueExecuting()
	        {
	            return false;
	        }

	        /**
	         * Keep ticking a continuous task that has already been started
	         */
	        public void updateTask()
	        {
	            BlockPos blockpos = EntityBee.this.getBoundOrigin();

	            if (blockpos == null)
	            {
	                blockpos = new BlockPos(EntityBee.this);
	            }

	            for (int i = 0; i < 3; ++i)
	            {
	                BlockPos blockpos1 = blockpos.add(EntityBee.this.rand.nextInt(15) - 7, EntityBee.this.rand.nextInt(11) - 5, EntityBee.this.rand.nextInt(15) - 7);

	                if (EntityBee.this.world.isAirBlock(blockpos1))
	                {
	                    EntityBee.this.moveHelper.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);

	                    if (EntityBee.this.getAttackTarget() == null)
	                    {
	                        EntityBee.this.getLookHelper().setLookPosition((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 180.0F, 20.0F);
	                    }

	                    break;
	                }
	            }
	        }
	    }
	  
	   class AIMoveControl extends EntityMoveHelper
	    {
	        public AIMoveControl(EntityBee bee)
	        {
	            super(bee);
	        }

	        public void onUpdateMoveHelper()
	        {
	            if (this.action == EntityMoveHelper.Action.MOVE_TO)
	            {
	                double d0 = this.posX - EntityBee.this.posX;
	                double d1 = this.posY - EntityBee.this.posY;
	                double d2 = this.posZ - EntityBee.this.posZ;
	                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
	                d3 = (double)MathHelper.sqrt(d3);

	                if (d3 < EntityBee.this.getEntityBoundingBox().getAverageEdgeLength())
	                {
	                    this.action = EntityMoveHelper.Action.WAIT;
	                    EntityBee.this.motionX *= 0.5D;
	                    EntityBee.this.motionY *= 0.5D;
	                    EntityBee.this.motionZ *= 0.5D;
	                }
	                else
	                {
	                    EntityBee.this.motionX += d0 / d3 * 0.05D * this.speed;
	                    EntityBee.this.motionY += d1 / d3 * 0.05D * this.speed;
	                    EntityBee.this.motionZ += d2 / d3 * 0.05D * this.speed;

	                    if (EntityBee.this.getAttackTarget() == null)
	                    {
	                        EntityBee.this.rotationYaw = -((float)MathHelper.atan2(EntityBee.this.motionX, EntityBee.this.motionZ)) * (180F / (float)Math.PI);
	                        EntityBee.this.renderYawOffset = EntityBee.this.rotationYaw;
	                    }
	                    else
	                    {
	                        double d4 = EntityBee.this.getAttackTarget().posX - EntityBee.this.posX;
	                        double d5 = EntityBee.this.getAttackTarget().posZ - EntityBee.this.posZ;
	                        EntityBee.this.rotationYaw = -((float)MathHelper.atan2(d4, d5)) * (180F / (float)Math.PI);
	                        EntityBee.this.renderYawOffset = EntityBee.this.rotationYaw;
	                    }
	                }
	            }
	        }
	    }
	  
	  
	  
	  

	
	
	
	
}