package dev.salmon.nohurtcam.mixin;

import dev.salmon.nohurtcam.NoHurtCam;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityRenderer.class)
public abstract class EntityRendererMixin {

    /**
     * @author Scherso (W-OVERFLOW) with the help of github.com/nxtdaydelivery
     * @reason Reduce, increase, or remove the hurt cam effect.
     */
    @Overwrite
    private void hurtCameraEffect(float partialTicks) {
        if (Minecraft.getMinecraft().getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)
                Minecraft.getMinecraft().getRenderViewEntity()).hurtTime > 0) {
            NoHurtCam.doHurtCam(partialTicks);
        }
    }

}