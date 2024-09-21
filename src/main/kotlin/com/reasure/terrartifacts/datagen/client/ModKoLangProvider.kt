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
        add(ModItems.WEAHER_RADIO, "날씨 라디오")
    }


    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "예제 블록")
    }

    override fun addTooltips() {
        add(TranslationKeys.HOUR_TOOLTIP_KEY, "1시간 단위로 시간을 표시합니다.")
        add(TranslationKeys.HALF_HOUR_TOOLTIP_KEY, "30분 단위로 시간을 표시합니다.")
        add(TranslationKeys.MINUTE_TOOLTIP_KEY, "1분 단위로 시간을 표시합니다.")
        add(TranslationKeys.WEATHER_RADIO_TOOLTIP_KEY, "현재 날씨를 표시합니다.")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "테라리아 유물들")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "테라리아 유물들 개발자 탭")
        addCuriosSlot("accessory", "악세서리")
        add(TranslationKeys.INFO_TIME_KEY, "⑴ %1\$s %2\$s")
        add(TranslationKeys.TIME_MORNING_KEY, "오전")
        add(TranslationKeys.TIME_AFTERNOON_KEY, "오후")
        add(TranslationKeys.TIME_BUTTON_MESSAGE, "시간")
        add(TranslationKeys.INFO_WEATHER_KEY, "⑵ %1\$s (\uD83D\uDCA7 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR_KEY, "맑음")
        add(TranslationKeys.WEATHER_CLOUDY_KEY, "흐림")
        add(TranslationKeys.WEATHER_RAIN_KEY, "비")
        add(TranslationKeys.WEATHER_SNOW_KEY, "눈")
        add(TranslationKeys.WEATHER_THUNDER_KEY, "천둥번개")
        add(TranslationKeys.WEATHER_BUTTON_MESSAGE, "날씨")
    }

    override fun addConfigs() {
        addConfigDesc("infoButtonLayoutPos", "정보 악세서리 토글 버튼 배치")
        addConfigDesc("infoButtonOffsetX", "정보 악세서리 토글 버튼 X 오프셋")
        addConfigDesc("infoButtonOffsetY", "정보 악세서리 토글 버튼 Y 오프셋")
    }
}