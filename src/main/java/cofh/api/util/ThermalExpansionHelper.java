package cofh.api.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to show how to use and provide an interface for Thermal Expansion's IMC Recipe manipulation.
 *
 * It is not the only way to add recipes to TE, but it is BY FAR the safest. Please use it.
 *
 * @author King Lemming
 */
public class ThermalExpansionHelper {

	private ThermalExpansionHelper() {

	}

	/**
	 * MACHINES
	 */

	/* FURNACE */
	public static void addFurnaceRecipe(int energy, ItemStack input, ItemStack output) {

		if (input.isEmpty() || output.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_FURNACE_RECIPE, toSend);
	}

	public static void removeFurnaceRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_FURNACE_RECIPE, toSend);
	}

	/* PULVERIZER */
	public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput) {

		addPulverizerRecipe(energy, input, primaryOutput, ItemStack.EMPTY, 0);
	}

	public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput) {

		addPulverizerRecipe(energy, input, primaryOutput, secondaryOutput, 100);
	}

	public static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int chance) {

		if (input.isEmpty() || primaryOutput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(PRIMARY_OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		primaryOutput.writeToNBT(toSend.getCompoundTag(PRIMARY_OUTPUT));

		if (!secondaryOutput.isEmpty()) {
			toSend.setTag(SECONDARY_OUTPUT, new NBTTagCompound());
			secondaryOutput.writeToNBT(toSend.getCompoundTag(SECONDARY_OUTPUT));
			toSend.setInteger(CHANCE, chance);
		}
		FMLInterModComms.sendMessage(MOD_ID, ADD_PULVERIZER_RECIPE, toSend);
	}

	public static void removePulverizerRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_PULVERIZER_RECIPE, toSend);
	}

	/* SAWMILL */
	public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput) {

		addSawmillRecipe(energy, input, primaryOutput, ItemStack.EMPTY, 0);
	}

	public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput) {

		addSawmillRecipe(energy, input, primaryOutput, secondaryOutput, 100);
	}

	public static void addSawmillRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int chance) {

		if (input.isEmpty() || primaryOutput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(PRIMARY_OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		primaryOutput.writeToNBT(toSend.getCompoundTag(PRIMARY_OUTPUT));

		if (!secondaryOutput.isEmpty()) {
			toSend.setTag(SECONDARY_OUTPUT, new NBTTagCompound());
			secondaryOutput.writeToNBT(toSend.getCompoundTag(SECONDARY_OUTPUT));
			toSend.setInteger(CHANCE, chance);
		}
		FMLInterModComms.sendMessage(MOD_ID, ADD_SAWMILL_RECIPE, toSend);
	}

	public static void removeSawmillRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_SAWMILL_RECIPE, toSend);
	}

	/* SMELTER */
	public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput) {

		addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput, ItemStack.EMPTY, 0);
	}

	public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput) {

		addSmelterRecipe(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, 100);
	}

	public static void addSmelterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int chance) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty() || primaryOutput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());
		toSend.setTag(PRIMARY_OUTPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		primaryOutput.writeToNBT(toSend.getCompoundTag(PRIMARY_OUTPUT));

		if (!secondaryOutput.isEmpty()) {
			toSend.setTag(SECONDARY_OUTPUT, new NBTTagCompound());
			secondaryOutput.writeToNBT(toSend.getCompoundTag(SECONDARY_OUTPUT));
			toSend.setInteger(CHANCE, chance);
		}
		FMLInterModComms.sendMessage(MOD_ID, ADD_SMELTER_RECIPE, toSend);
	}

	public static void removeSmelterRecipe(ItemStack primaryInput, ItemStack secondaryInput) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_SMELTER_RECIPE, toSend);
	}

	/* INSOLATOR */
	public static void addInsolatorRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput) {

		addInsolatorRecipe(energy, primaryInput, secondaryInput, primaryOutput, ItemStack.EMPTY, 0);
	}

	public static void addInsolatorRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput) {

		addInsolatorRecipe(energy, primaryInput, secondaryInput, primaryOutput, secondaryOutput, 100);
	}

	public static void addInsolatorRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, ItemStack secondaryOutput, int chance) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty() || primaryOutput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());
		toSend.setTag(PRIMARY_OUTPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		primaryOutput.writeToNBT(toSend.getCompoundTag(PRIMARY_OUTPUT));

		if (!secondaryOutput.isEmpty()) {
			toSend.setTag(SECONDARY_OUTPUT, new NBTTagCompound());
			secondaryOutput.writeToNBT(toSend.getCompoundTag(SECONDARY_OUTPUT));
			toSend.setInteger(CHANCE, chance);
		}
		FMLInterModComms.sendMessage(MOD_ID, ADD_INSOLATOR_RECIPE, toSend);
	}

	public static void removeInsolatorRecipe(ItemStack primaryInput, ItemStack secondaryInput) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_INSOLATOR_RECIPE, toSend);
	}

	/* COMPACTOR */
	public static void addCompactorPressRecipe(int energy, ItemStack input, ItemStack output) {

		if (input.isEmpty() || output.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_COMPACTOR_PRESS_RECIPE, toSend);
	}

	public static void addCompactorStorageRecipe(int energy, ItemStack input, ItemStack output) {

		if (input.isEmpty() || output.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_COMPACTOR_STORAGE_RECIPE, toSend);
	}

	public static void addCompactorMintRecipe(int energy, ItemStack input, ItemStack output) {

		if (input.isEmpty() || output.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_COMPACTOR_MINT_RECIPE, toSend);
	}

	public static void removeCompactorPressRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_COMPACTOR_PRESS_RECIPE, toSend);
	}

	public static void removeCompactorStorageRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_COMPACTOR_STORAGE_RECIPE, toSend);
	}

	public static void removeCompactorMintRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_COMPACTOR_MINT_RECIPE, toSend);
	}

	/* CRUCIBLE */
	public static void addCrucibleRecipe(int energy, ItemStack input, FluidStack output) {

		if (input.isEmpty() || output == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));

		FMLInterModComms.sendMessage(MOD_ID, ADD_CRUCIBLE_RECIPE, toSend);
	}

	public static void removeCrucibleRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_CRUCIBLE_RECIPE, toSend);
	}

	/* REFINERY */
	public static void addRefineryRecipe(int energy, FluidStack input, FluidStack output, ItemStack outputItem) {

		if (input == null || output == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		if (!outputItem.isEmpty()) {
			toSend.setTag(SECONDARY_OUTPUT, new NBTTagCompound());
			outputItem.writeToNBT(toSend.getCompoundTag(SECONDARY_OUTPUT));
		}
		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));

		FMLInterModComms.sendMessage(MOD_ID, ADD_REFINERY_RECIPE, toSend);
	}

	public static void removeRefineryRecipe(FluidStack input) {

		if (input == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_REFINERY_RECIPE, toSend);
	}

	/* TRANSPOSER */
	public static void addTransposerFill(int energy, ItemStack input, ItemStack output, FluidStack fluid, boolean reversible) {

		if (input.isEmpty() || output.isEmpty() || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());
		toSend.setTag(FLUID, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		toSend.setBoolean(REVERSIBLE, reversible);
		fluid.writeToNBT(toSend.getCompoundTag(FLUID));

		FMLInterModComms.sendMessage(MOD_ID, ADD_TRANSPOSER_FILL_RECIPE, toSend);
	}

	public static void addTransposerExtract(int energy, ItemStack input, ItemStack output, FluidStack fluid, int chance, boolean reversible) {

		if (input.isEmpty() || output.isEmpty() || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());
		toSend.setTag(FLUID, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		toSend.setBoolean(REVERSIBLE, reversible);
		toSend.setInteger(CHANCE, chance);
		fluid.writeToNBT(toSend.getCompoundTag(FLUID));

		FMLInterModComms.sendMessage(MOD_ID, ADD_TRANSPOSER_EXTRACT_RECIPE, toSend);
	}

	public static void removeTransposerFill(ItemStack input, FluidStack fluid) {

		if (input.isEmpty() || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(FLUID, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		fluid.writeToNBT(toSend.getCompoundTag(FLUID));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_TRANSPOSER_FILL_RECIPE, toSend);
	}

	public static void removeTransposerExtract(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_TRANSPOSER_EXTRACT_RECIPE, toSend);
	}

	/* CHARGER */
	public static void addChargerRecipe(int energy, ItemStack input, ItemStack output) {

		if (input.isEmpty() || output.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		output.writeToNBT(toSend.getCompoundTag(OUTPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_CHARGER_RECIPE, toSend);
	}

	public static void removeChargerRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_CHARGER_RECIPE, toSend);
	}

	/* CENTRIFUGE */
	public static void addCentrifugeRecipe(int energy, ItemStack input, List<ItemStack> output) {

		addCentrifugeRecipe(energy, input, output, new ArrayList<>(), null);
	}

	public static void addCentrifugeRecipe(int energy, ItemStack input, List<ItemStack> output, List<Integer> chance) {

		addCentrifugeRecipe(energy, input, output, chance, null);
	}

	public static void addCentrifugeRecipe(int energy, ItemStack input, FluidStack fluid) {

		addCentrifugeRecipe(energy, input, new ArrayList<>(), new ArrayList<>(), fluid);
	}

	public static void addCentrifugeRecipe(int energy, ItemStack input, List<ItemStack> output, List<Integer> chance, FluidStack fluid) {

		if (input.isEmpty() || output.size() > 4 || chance.size() > 4 || (!chance.isEmpty() && chance.size() != output.size()) || output.isEmpty() && fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));

		if (!output.isEmpty()) {
			NBTTagList list = new NBTTagList();

			for (int i = 0; i < output.size(); i++) {
				NBTTagCompound tag = new NBTTagCompound();
				output.get(i).writeToNBT(tag);
				if (!chance.isEmpty()) {
					tag.setInteger(CHANCE, chance.get(i));
				}
				list.appendTag(tag);
			}
			toSend.setTag(OUTPUT, list);
		}
		if (fluid != null) {
			toSend.setTag(FLUID, new NBTTagCompound());
			fluid.writeToNBT(toSend.getCompoundTag(FLUID));
		}
		FMLInterModComms.sendMessage(MOD_ID, ADD_CENTRIFUGE_RECIPE, toSend);
	}

	public static void removeCentrifugeRecipe(ItemStack input) {

		if (input.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_CENTRIFUGE_RECIPE, toSend);
	}

	/* BREWER */
	public static void addBrewerRecipe(int energy, ItemStack input, FluidStack inputFluid, FluidStack outputFluid) {

		if (input.isEmpty() || inputFluid == null || outputFluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());
		toSend.setTag(OUTPUT, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		inputFluid.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		outputFluid.writeToNBT(toSend.getCompoundTag(OUTPUT));

		FMLInterModComms.sendMessage(MOD_ID, ADD_BREWER_RECIPE, toSend);
	}

	public static void removeBrewerRecipe(ItemStack input, FluidStack fluid) {

		if (input.isEmpty() || fluid == null) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setTag(FLUID, new NBTTagCompound());

		input.writeToNBT(toSend.getCompoundTag(INPUT));
		fluid.writeToNBT(toSend.getCompoundTag(FLUID));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_BREWER_RECIPE, toSend);
	}

	/* ENCHANTER */
	public static void addEnchanterRecipe(int energy, ItemStack primaryInput, ItemStack secondaryInput, ItemStack primaryOutput, int fluidExp) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty() || primaryOutput.isEmpty() || fluidExp < 0) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setInteger(ENERGY, energy);
		toSend.setInteger(EXPERIENCE, fluidExp);
		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());
		toSend.setTag(PRIMARY_OUTPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		primaryOutput.writeToNBT(toSend.getCompoundTag(PRIMARY_OUTPUT));

		FMLInterModComms.sendMessage(MOD_ID, ADD_ENCHANTER_RECIPE, toSend);
	}

	public static void removeEnchanterRecipe(ItemStack primaryInput, ItemStack secondaryInput) {

		if (primaryInput.isEmpty() || secondaryInput.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(PRIMARY_INPUT, new NBTTagCompound());
		toSend.setTag(SECONDARY_INPUT, new NBTTagCompound());

		primaryInput.writeToNBT(toSend.getCompoundTag(PRIMARY_INPUT));
		secondaryInput.writeToNBT(toSend.getCompoundTag(SECONDARY_INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_ENCHANTER_RECIPE, toSend);
	}

	/**
	 * DYNAMOS
	 */

	/* STEAM */
	public static void addSteamFuel(ItemStack fuel, int energy) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setInteger(ENERGY, energy);

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_STEAM_FUEL, toSend);
	}

	public static void removeSteamFuel(ItemStack fuel) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_STEAM_FUEL, toSend);
	}

	/* MAGMATIC */
	public static void addMagmaticFuel(String fluidName, int energy) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);
		toSend.setInteger(ENERGY, energy);

		FMLInterModComms.sendMessage(MOD_ID, ADD_MAGMATIC_FUEL, toSend);
	}

	public static void removeMagmaticFuel(String fluidName) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);

		FMLInterModComms.sendMessage(MOD_ID, REMOVE_MAGMATIC_FUEL, toSend);
	}

	/* COMPRESSION */
	public static void addCompressionFuel(String fluidName, int energy) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);
		toSend.setInteger(ENERGY, energy);

		FMLInterModComms.sendMessage(MOD_ID, ADD_COMPRESSION_FUEL, toSend);
	}

	public static void removeCompressionFuel(String fluidName) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);

		FMLInterModComms.sendMessage(MOD_ID, REMOVE_COMPRESSION_FUEL, toSend);
	}

	/* REACTANT */
	public static void addReactantFuel(ItemStack reactant, String fluidName, int energy) {

		if (reactant.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setString(FLUID_NAME, fluidName);
		toSend.setInteger(ENERGY, energy);

		reactant.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_REACTANT_FUEL, toSend);
	}

	public static void removeReactantFuel(ItemStack reactant, String fluidName) {

		if (reactant.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setString(FLUID_NAME, fluidName);

		reactant.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_REACTANT_FUEL, toSend);
	}

	/* ENERVATION */
	public static void addEnervationFuel(ItemStack fuel, int energy) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setInteger(ENERGY, energy);

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_ENERVATION_FUEL, toSend);
	}

	public static void removeEnervationFuel(ItemStack fuel) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_ENERVATION_FUEL, toSend);
	}

	/* NUMISMATIC */
	public static void addNumismaticFuel(ItemStack fuel, int energy) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());
		toSend.setInteger(ENERGY, energy);

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, ADD_NUMISMATIC_FUEL, toSend);
	}

	public static void removeNumismaticFuel(ItemStack fuel) {

		if (fuel.isEmpty()) {
			return;
		}
		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setTag(INPUT, new NBTTagCompound());

		fuel.writeToNBT(toSend.getCompoundTag(INPUT));
		FMLInterModComms.sendMessage(MOD_ID, REMOVE_NUMISMATIC_FUEL, toSend);
	}

	/* COOLANT */
	public static void addCoolant(String fluidName, int energy, int factor) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);
		toSend.setInteger(ENERGY, energy);
		toSend.setInteger(FACTOR, factor);

		FMLInterModComms.sendMessage(MOD_ID, ADD_COOLANT, toSend);
	}

	public static void removeCoolant(String fluidName) {

		NBTTagCompound toSend = new NBTTagCompound();

		toSend.setString(FLUID_NAME, fluidName);

		FMLInterModComms.sendMessage(MOD_ID, REMOVE_COOLANT, toSend);
	}

	/* IMC STRINGS */
	static final String MOD_ID = "thermalexpansion";

	static final String ENERGY = "energy";
	static final String EXPERIENCE = "experience";
	static final String FLUID = "fluid";
	static final String FLUID_NAME = "fluidName";
	static final String REVERSIBLE = "reversible";
	static final String CHANCE = "chance";
	static final String FACTOR = "factor";

	static final String INPUT = "input";
	static final String OUTPUT = "output";
	static final String PRIMARY_INPUT = "primaryInput";
	static final String SECONDARY_INPUT = "secondaryInput";
	static final String PRIMARY_OUTPUT = "primaryOutput";
	static final String SECONDARY_OUTPUT = "secondaryOutput";

	public static final String ADD_FURNACE_RECIPE = "addfurnacerecipe";
	public static final String ADD_PULVERIZER_RECIPE = "addpulverizerrecipe";
	public static final String ADD_SAWMILL_RECIPE = "addsawmillrecipe";
	public static final String ADD_SMELTER_RECIPE = "addsmelterrecipe";
	public static final String ADD_INSOLATOR_RECIPE = "addinsolatorrecipe";
	public static final String ADD_COMPACTOR_PRESS_RECIPE = "addcompactorpressrecipe";
	public static final String ADD_COMPACTOR_STORAGE_RECIPE = "addcompactorstoragerecipe";
	public static final String ADD_COMPACTOR_MINT_RECIPE = "addcompactormintrecipe";
	public static final String ADD_CRUCIBLE_RECIPE = "addcruciblerecipe";
	public static final String ADD_REFINERY_RECIPE = "addrefineryrecipe";
	public static final String ADD_TRANSPOSER_FILL_RECIPE = "addtransposerfillrecipe";
	public static final String ADD_TRANSPOSER_EXTRACT_RECIPE = "addtransposerextractrecipe";
	public static final String ADD_CHARGER_RECIPE = "addchargerrecipe";
	public static final String ADD_CENTRIFUGE_RECIPE = "addcentrifugerecipe";
	public static final String ADD_BREWER_RECIPE = "addbrewerrecipe";
	public static final String ADD_ENCHANTER_RECIPE = "addenchanterrecipe";

	public static final String REMOVE_FURNACE_RECIPE = "removefurnacerecipe";
	public static final String REMOVE_PULVERIZER_RECIPE = "removepulverizerrecipe";
	public static final String REMOVE_SAWMILL_RECIPE = "removesawmillrecipe";
	public static final String REMOVE_SMELTER_RECIPE = "removesmelterrecipe";
	public static final String REMOVE_INSOLATOR_RECIPE = "removeinsolatorrecipe";
	public static final String REMOVE_COMPACTOR_PRESS_RECIPE = "removecompactorpressrecipe";
	public static final String REMOVE_COMPACTOR_STORAGE_RECIPE = "removecompactorstoragerecipe";
	public static final String REMOVE_COMPACTOR_MINT_RECIPE = "removecompactormintrecipe";
	public static final String REMOVE_CRUCIBLE_RECIPE = "removecruciblerecipe";
	public static final String REMOVE_REFINERY_RECIPE = "removerefineryrecipe";
	public static final String REMOVE_TRANSPOSER_FILL_RECIPE = "removetransposerfillrecipe";
	public static final String REMOVE_TRANSPOSER_EXTRACT_RECIPE = "removetransposerextractrecipe";
	public static final String REMOVE_CHARGER_RECIPE = "removechargerrecipe";
	public static final String REMOVE_CENTRIFUGE_RECIPE = "removecentrifugerecipe";
	public static final String REMOVE_BREWER_RECIPE = "removebrewerrecipe";
	public static final String REMOVE_ENCHANTER_RECIPE = "removeenchanterrecipe";

	public static final String ADD_STEAM_FUEL = "addsteamfuel";
	public static final String ADD_MAGMATIC_FUEL = "addmagmaticfuel";
	public static final String ADD_COMPRESSION_FUEL = "addcompressionfuel";
	public static final String ADD_REACTANT_FUEL = "addreactantfuel";
	public static final String ADD_ENERVATION_FUEL = "addenervationfuel";
	public static final String ADD_NUMISMATIC_FUEL = "addnumismaticfuel";

	public static final String REMOVE_STEAM_FUEL = "removesteamfuel";
	public static final String REMOVE_MAGMATIC_FUEL = "removemagmaticfuel";
	public static final String REMOVE_COMPRESSION_FUEL = "removecompressionfuel";
	public static final String REMOVE_REACTANT_FUEL = "removereactantfuel";
	public static final String REMOVE_ENERVATION_FUEL = "removeenervationfuel";
	public static final String REMOVE_NUMISMATIC_FUEL = "removenumismaticfuel";

	public static final String ADD_COOLANT = "addcoolant";
	public static final String REMOVE_COOLANT = "removecoolant";

}
