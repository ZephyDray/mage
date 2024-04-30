package mage.cards.v;

import mage.MageInt;
import mage.abilities.common.GainLifeControllerTriggeredAbility;
import mage.abilities.common.LoseLifeTriggeredAbility;
import mage.abilities.condition.common.MyTurnCondition;
import mage.abilities.decorator.ConditionalBatchTriggeredAbility;
import mage.abilities.decorator.ConditionalTriggeredAbility;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.TargetController;
import mage.counters.CounterType;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class VampireScrivener extends CardImpl {

    public VampireScrivener(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{4}{B}");

        this.subtype.add(SubType.VAMPIRE);
        this.subtype.add(SubType.WARLOCK);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // Flying
        this.addAbility(FlyingAbility.getInstance());

        // Whenever you gain life during your turn, put a +1/+1 counter on Vampire Scrivener.
        this.addAbility(new ConditionalTriggeredAbility(new GainLifeControllerTriggeredAbility(
                new AddCountersSourceEffect(CounterType.P1P1.createInstance())), MyTurnCondition.instance,
                "Whenever you gain life during your turn, put a +1/+1 counter on {this}."
        ));

        // Whenever you lose life during your turn, put a +1/+1 counter on Vampire Scrivener.
        this.addAbility(new ConditionalBatchTriggeredAbility(new LoseLifeTriggeredAbility(
                new AddCountersSourceEffect(CounterType.P1P1.createInstance()), TargetController.YOU),
                MyTurnCondition.instance, "Whenever you lose life during your turn, put a +1/+1 counter on {this}."
        ));
    }

    private VampireScrivener(final VampireScrivener card) {
        super(card);
    }

    @Override
    public VampireScrivener copy() {
        return new VampireScrivener(this);
    }
}