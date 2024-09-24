package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.TranslationKeys
import net.minecraft.data.PackOutput

class ModKoLangProvider(output: PackOutput) :
    ModBaseLangProvider(output, "ko_kr") {
    override fun addItems() {
        add(ModItems.COPPER_CLOCK, "기본 구리 시계")
        add(ModItems.TIN_CLOCK, "기본 주석 시계")
        add(ModItems.SILVER_CLOCK, "기본 은 시계")
        add(ModItems.TUNGSTEN_CLOCK, "기본 텅스텐 시계")
        add(ModItems.PLATINUM_CLOCK, "기본 백금 시계")
        add(ModItems.COPPER_WATCH, "구리 시계")
        add(ModItems.TIN_WATCH, "주석 시계")
        add(ModItems.SILVER_WATCH, "은 시계")
        add(ModItems.TUNGSTEN_WATCH, "텅스텐 시계")
        add(ModItems.GOLD_WATCH, "금 시계")
        add(ModItems.PLATINUM_WATCH, "백금 시계")
        add(ModItems.WEATHER_RADIO, "날씨 라디오")
        add(ModItems.FISHERMAN_POCKET_GUIDE, "낚시꾼의 휴대용 가이드")
        add(ModItems.COMPASS, "나침반")
        add(ModItems.DEPTH_METER, "깊이 측정기")
        add(ModItems.RADAR, "레이더")
        add(ModItems.GPS, "GPS")
    }


    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "예제 블록")
    }

    override fun addTooltips() {
        add(TranslationKeys.TOOLTIP_WATCH_HOUR, "1시간 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_WATCH_HALF_HOUR, "30분 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_WATCH_MINUTE, "1분 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_WEATHER_RADIO, "현재 날씨를 표시합니다.")
        add(TranslationKeys.TOOLTIP_FISHERMAN_POCKET_GUIDE, "낚시 힘을 표시합니다.")
        add(TranslationKeys.TOOLTIP_COMPASS, "수평 방향 정보를 표시합니다.")
        add(TranslationKeys.TOOLTIP_DEPTH_METER, "수직 방향 정보를 표시합니다.")
        add(TranslationKeys.TOOLTIP_RADAR, "근처 몬스터의 수를 표시합니다.")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "테라리아 유물들")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "테라리아 유물들 개발자 탭")
        addCuriosSlot("accessory", "악세서리")
        add(TranslationKeys.INFO_TIME, "⑴ %1\$s %2\$s")
        add(TranslationKeys.TIME_MORNING, "오전")
        add(TranslationKeys.TIME_AFTERNOON, "오후")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME, "시간")
        add(TranslationKeys.INFO_WEATHER, "⑵ %1\$s (💧 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR, "맑음")
        add(TranslationKeys.WEATHER_CLOUDY, "흐림")
        add(TranslationKeys.WEATHER_RAIN, "비")
        add(TranslationKeys.WEATHER_SNOW, "눈")
        add(TranslationKeys.WEATHER_THUNDER, "천둥번개")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER, "날씨")
        add(TranslationKeys.INFO_FISHING_POWER, "⑶ 운: %s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER, "낚시 힘")
        add(TranslationKeys.INFO_POSITION, "⑷ X: %1\$s, Z: %1\$s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION, "위치")
        add(TranslationKeys.INFO_DEPTH, "⑸ 깊이: %s")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH, "깊이")
        add(TranslationKeys.INFO_ENEMY_COUNT, "⑹ 근처에 적 %s마리!")
        add(TranslationKeys.INFO_NO_ENEMY_COUNT, "⑹ 근처에 적 없음")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT, "몬스터 수")
    }

    override fun addConfigs() {
        addConfigDesc("infoButtonLayoutPos", "정보 악세서리 토글 버튼 배치")
        addConfigDesc("infoButtonOffsetX", "정보 악세서리 토글 버튼 X 오프셋")
        addConfigDesc("infoButtonOffsetY", "정보 악세서리 토글 버튼 Y 오프셋")
    }
}