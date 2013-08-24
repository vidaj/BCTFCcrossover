package emris.BCTFCcrossover.pipes.transport;

import net.minecraftforge.common.ForgeDirection;
import buildcraft.api.core.IIconProvider;
import buildcraft.transport.pipes.PipeItemsQuartz;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emris.BCTFCcrossover.BCTFCcrossover;
import emris.BCTFCcrossover.core.PipeIconProvider;

public class SterlingSilverPipeItem extends PipeItemsQuartz
{
	public SterlingSilverPipeItem(int itemID) {
		super(itemID);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BCTFCcrossover.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return PipeIconProvider.TYPE.PipeSterlingSilver.ordinal();
	}
}
