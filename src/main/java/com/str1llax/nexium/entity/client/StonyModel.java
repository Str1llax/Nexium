package com.str1llax.nexium.entity.client;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.str1llax.nexium.entity.animations.NexiumAnimationDefinitions;
import com.str1llax.nexium.entity.custom.StonyEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class StonyModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart Stony;
	private final ModelPart RightLeg;
	private final ModelPart RightFeet;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFeet;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public StonyModel(ModelPart root) {
		this.Stony = root.getChild("Stony");
		this.RightLeg = this.Stony.getChild("RightLeg");
		this.RightFeet = this.RightLeg.getChild("RightFeet");
		this.LeftLeg = this.Stony.getChild("LeftLeg");
		this.LeftFeet = this.LeftLeg.getChild("LeftFeet");
		this.Body = this.Stony.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Stony = partdefinition.addOrReplaceChild("Stony", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition RightLeg = Stony.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(28, 32).addBox(-1.5F, -0.5F, -1.25F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.5F, -0.75F));

		PartDefinition RightFeet = RightLeg.addOrReplaceChild("RightFeet", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, -0.25F));

		PartDefinition LeftLeg = Stony.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -0.5F, -1.25F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.5F, -0.75F));

		PartDefinition LeftFeet = LeftLeg.addOrReplaceChild("LeftFeet", CubeListBuilder.create().texOffs(14, 32).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, -0.25F));

		PartDefinition Body = Stony.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(18, 38).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, -1.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(12, 38).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, -1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(NexiumAnimationDefinitions.STONY_WALK, limbSwing, limbSwingAmount, 2.0f, 2.5f);
		this.animate(((StonyEntity)entity).idleAnimationState, NexiumAnimationDefinitions.STONY_IDLE, ageInTicks, 1f);
		this.animate(((StonyEntity)entity).attackAnimationState, NexiumAnimationDefinitions.STONY_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Stony.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Stony;
	}
}