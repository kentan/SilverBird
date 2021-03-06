package org.smartbirdpj.engine.validator;


import org.smartbirdpj.engine.controller.WinningHands;
import org.smartbirdpj.engine.controller.WinningHandsBasic;
import org.smartbirdpj.mdl.MeldElement;
import org.smartbirdpj.mdl.enm.MeldEnum;
import org.smartbirdpj.mdl.enm.TileEnum;
import org.smartbirdpj.mdl.enm.WinningHandsEnum;


public class JunchanValidator extends WinningHandsValidator {
	public boolean validate(WinningHands winningHands, WinningHandsStatus status) {
		if (status.isHigherWinningHandsValid(WinningHandsEnum.JUNCHAN)) {
			return false;
		}

		for (MeldElement meld : ((WinningHandsBasic)winningHands).getList()) {
			TileEnum tile = meld.getList().get(0);
			if (MeldEnum.WALL_CHOW.equals(meld.getMeldEnum()) || MeldEnum.STEAL_CHOW.equals(meld.getMeldEnum())) {

				if (TileEnum.CHARACTOR1.equals(tile) || TileEnum.CHARACTOR7.equals(tile) || TileEnum.BAMBOO1.equals(tile) || TileEnum.BAMBOO7.equals(tile)
						|| TileEnum.CIRCLE1.equals(tile) || TileEnum.CIRCLE7.equals(tile)) {
					continue;
				} else {
					return false;
				}
			} else {
				if (TileEnum.CHARACTOR1.equals(tile) || TileEnum.CHARACTOR9.equals(tile) || TileEnum.BAMBOO1.equals(tile) || TileEnum.BAMBOO9.equals(tile)
						|| TileEnum.CIRCLE1.equals(tile) || TileEnum.CIRCLE9.equals(tile)) {
					continue;
				} else {
					return false;
				}
			}

		}
		status.isJuntyan = true;
		return true;
	}
}
