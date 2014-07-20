package org.smartbirdpj.engine.validator;


import org.smartbirdpj.engine.controller.WinningHands;
import org.smartbirdpj.engine.controller.WinningHandsBasic;
import org.smartbirdpj.mdl.MeldElement;
import org.smartbirdpj.mdl.enm.MeldEnum;
import org.smartbirdpj.mdl.enm.TileEnum;
import org.smartbirdpj.mdl.enm.WinningHandsEnum;


public class ChantaValidator extends WinningHandsValidator {
	public boolean validate(WinningHands winningHands, WinningHandsStatus status) {
		if (status.isHigherWinningHandsValid(WinningHandsEnum.CHANTA)) {
			return false;
		}

		for (MeldElement melds : ((WinningHandsBasic)winningHands).getList()) {
			if (MeldEnum.WALL_PONG.equals(melds.getMeldEnum()) || MeldEnum.EYES.equals(melds.getMeldEnum())
					|| MeldEnum.WALL_KONG.equals(melds.getMeldEnum()) || MeldEnum.STEAL_PONG.equals(melds.getMeldEnum())
					|| MeldEnum.STEAL_KONG.equals(melds.getMeldEnum())) {
				if (melds.getList().get(0).isTanyao()) {
					return false;
				}
			} else {
				TileEnum tile = melds.getList().get(0);
				if (TileEnum.CHARACTOR1.equals(tile) || TileEnum.CHARACTOR7.equals(tile) || TileEnum.CIRCLE1.equals(tile) || TileEnum.CIRCLE7.equals(tile)
						|| TileEnum.BAMBOO1.equals(tile) || TileEnum.BAMBOO7.equals(tile)) {
					continue;
				} else {
					return false;
				}
			}
		}
		status.isChanta = true;
		return true;
	}
}
