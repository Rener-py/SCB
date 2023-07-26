package net.mcreator.scbreforged.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcustom_model_2<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("scb", "modelcustom_model_2"), "main");
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public Modelcustom_model_2(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.5F)).texOffs(10, 1)
						.addBox(-5.5F, -10.8F, -0.9F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1).addBox(-5.5F, -10.8F, 3.6F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1)
						.addBox(-5.5F, -10.8F, -5.0F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1).addBox(5.0F, -10.8F, -5.0F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1)
						.addBox(5.0F, -10.8F, -0.9F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1).addBox(5.0F, -10.8F, 3.3F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 1).addBox(-0.425F, -1.95F, -0.4F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1)
				.addBox(-0.425F, -1.95F, -4.5F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1).addBox(-0.425F, -1.95F, 4.1F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -10.8F, -0.5F, 0.0F, 0.0F, 0.5411F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 1).addBox(-0.55F, -2.225F, -0.4F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1)
				.addBox(-0.55F, -2.225F, -4.6F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)).texOffs(10, 1).addBox(-0.55F, -2.225F, -8.7F, 0.5F, 2.2F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.5F, -10.8F, 3.7F, 0.0F, 0.0F, -0.6109F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)).texOffs(1, 29).addBox(-5.025F, 0.3F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(1.15F, 0.3F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(1.15F, 2.525F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(1.15F, 4.875F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(1.15F, 7.125F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(1.15F, 0.325F, 3.0F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(1.15F, 7.25F, 3.0F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(1.15F, 2.375F, 3.0F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(1.15F, 4.825F, 3.0F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(-5.025F, 0.325F, 2.975F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(-5.025F, 2.525F, 2.975F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(-5.025F, 4.85F, 2.975F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(-5.025F, 7.25F, 2.975F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(-5.025F, 2.5F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29).addBox(-5.025F, 4.875F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)).texOffs(1, 29)
						.addBox(-5.025F, 7.35F, -3.325F, 3.875F, 0.8F, 0.3F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).texOffs(9, 0).addBox(-2.475F, -2.0F, -3.525F, 2.025F, 8.95F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r3 = RightArm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 0).addBox(-0.8324F, -4.35F, 4.2798F, 2.025F, 8.95F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.875F, 2.35F, 0.3F, 0.0F, 1.597F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2094F, 0.0F, 0.0F));
		PartDefinition cube_r4 = LeftArm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 0).addBox(-0.25F, -5.1481F, -1.5725F, 2.025F, 8.95F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4F, 3.1F, -2.1F, 0.0131F, 0.0F, 0.0F));
		PartDefinition cube_r5 = LeftArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(9, 0).addBox(-0.2463F, -3.3528F, -0.3965F, 2.025F, 8.95F, 0.6F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.425F, 1.35F, 0.9F, 2.0347F, 1.5123F, 2.034F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)),
				PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.192F, 0.0F, 0.0349F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.1745F, 0.0F, -0.0349F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
