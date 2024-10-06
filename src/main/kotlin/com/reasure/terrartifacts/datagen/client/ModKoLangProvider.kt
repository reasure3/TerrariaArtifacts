package com.reasure.terrartifacts.datagen.client

import com.reasure.terrartifacts.block.ModBlocks
import com.reasure.terrartifacts.item.ModItems
import com.reasure.terrartifacts.util.ModTags
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
        add(ModItems.TALLY_COUNTER, "탤리 카운터")
        add(ModItems.SEXTANT, "육분의")
        add(ModItems.STOPWATCH, "스톱워치")
        add(ModItems.METAL_DETECTOR, "금속 감지기")
        add(ModItems.LIFEFORM_ANALYZER, "생물 형태 분석기")
        add(ModItems.DPS_METER, "DPS 측정기")
        add(ModItems.GPS, "GPS")
        add(ModItems.FISH_FINDER, "어류 탐지기")
        add(ModItems.REK3000, "R.E.K. 3000")
    }


    override fun addBlocks() {
        add(ModBlocks.EXAMPLE_BLOCK, "예제 블록")
    }

    override fun addTooltips() {
        add(TranslationKeys.TOOLTIP_TIME_HOUR_ITEM, "⑴ 1시간 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_TIME_HALF_HOUR_ITEM, "⑴ 30분 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_TIME_MINUTE_ITEM, "⑴ 1분 단위로 시간을 표시합니다.")
        add(TranslationKeys.TOOLTIP_WEATHER_ITEM, "⑵ 현재 날씨를 표시합니다.")
        add(TranslationKeys.TOOLTIP_FISHING_POWER_ITEM, "⑶ 낚시 힘을 표시합니다.")
        add(TranslationKeys.TOOLTIP_POSITION_ITEM, "⑷ 수평 방향 정보를 표시합니다.")
        add(TranslationKeys.TOOLTIP_DEPTH_ITEM, "⑸ 수직 방향 정보를 표시합니다.")
        add(TranslationKeys.TOOLTIP_ENEMY_COUNT_ITEM, "⑹ 근처 몬스터의 수를 표시합니다.")
        add(TranslationKeys.TOOLTIP_KILL_COUNT_ITEM, "⑺ 각 엔티티 마다 죽인 횟수를 표시합니다.")
        add(TranslationKeys.TOOLTIP_MOON_PHASE_ITEM, "⑻ 달의 위상 정보를 표시합니다.")
        add(TranslationKeys.TOOLTIP_MOVEMENT_SPEED_ITEM, "⑽ 이동 속도를 표시합니다.")
        add(TranslationKeys.TOOLTIP_TREASURE_ITEM, "⑾ 주변의 보물을 표시합니다.")
        add(TranslationKeys.TOOLTIP_RARE_CREATURES_ITEM, "⑿ 주변의 희귀한 생물을 표시합니다.")
        add(TranslationKeys.TOOLTIP_DPS_ITEM, "⒀ 초당 데미지를 표시합니다.")
    }

    override fun addGui() {
        add(TranslationKeys.GROUP_TERRARTIFACTS_KEY, "테라리아 유물들")
        add(TranslationKeys.GROUP_TERRARTIFACTS_DEVELOP_KEY, "테라리아 유물들 개발자 탭")
        addCuriosSlot("accessory", "악세서리")
        addInfoOverlays()
        addInfoToggleButtons()
    }

    private fun addInfoOverlays() {
        // TIME
        add(TranslationKeys.INFO_TIME, "⑴ %1\$s %2\$s")
        add(TranslationKeys.TIME_MORNING, "오전")
        add(TranslationKeys.TIME_AFTERNOON, "오후")
        // WEATHER
        add(TranslationKeys.INFO_WEATHER, "⑵ %1\$s (💧 %2\$s%%, ⚡ %3\$s%%)")
        add(TranslationKeys.WEATHER_CLEAR, "맑음")
        add(TranslationKeys.WEATHER_CLOUDY, "흐림")
        add(TranslationKeys.WEATHER_RAIN, "비")
        add(TranslationKeys.WEATHER_SNOW, "눈")
        add(TranslationKeys.WEATHER_THUNDER, "천둥번개")
        // FISHING POWER
        add(TranslationKeys.INFO_FISHING_POWER, "⑶ 운: %s")
        // POSITION
        add(TranslationKeys.INFO_POSITION, "⑷ X: %1\$s, Z: %1\$s")
        // DEPTH
        add(TranslationKeys.INFO_DEPTH, "⑸ Y: %s")
        // ENEMY COUNT
        add(TranslationKeys.INFO_ENEMY_COUNT, "⑹ 근처에 적 %s마리!")
        add(TranslationKeys.INFO_NO_ENEMY_COUNT, "⑹ 근처에 적 없음")
        // KILL COUNT
        add(TranslationKeys.INFO_KILL_COUNT, "⑺ %1\$s: %2\$s")
        add(TranslationKeys.INFO_NO_KILL_COUNT, "⑺ 죽인 횟수 없음")
        // MOON PHASE
        add(TranslationKeys.INFO_MOON_PHASE_FULL_MOON, "⑻ 보름달")
        add(TranslationKeys.INFO_MOON_PHASE_WANING_GIBBOUS, "⑻ 볼록 하현달")
        add(TranslationKeys.INFO_MOON_PHASE_LAST_QUARTER, "⑻ 하현달")
        add(TranslationKeys.INFO_MOON_PHASE_WANING_CRESCENT, "⑻ 그믐달")
        add(TranslationKeys.INFO_MOON_PHASE_NEW_MOON, "⑻ 신월")
        add(TranslationKeys.INFO_MOON_PHASE_WAXING_CRESCENT, "⑻ 초승달")
        add(TranslationKeys.INFO_MOON_PHASE_FIRST_QUARTER, "⑻ 상현달")
        add(TranslationKeys.INFO_MOON_PHASE_WAXING_GIBBOUS, "⑻ 볼록 상현달")
        add(TranslationKeys.INFO_NO_MOON_PHASE, "⑼ 달 없음")
        add(TranslationKeys.INFO_NETHER_MOON_PHASE, "⑼ 네더 달")
        add(TranslationKeys.INFO_END_MOON_PHASE, "⑼ 엔더 달")
        // MOVEMENT SPEED
        add(TranslationKeys.INFO_MOVEMENT_SPEED, "⑽ %s m/s")
        // TREASURE
        add(TranslationKeys.INFO_TREASURE, "⑾ 근처에 %s 탐지됨!")
        add(TranslationKeys.INFO_NO_TREASURE, "⑾ 탐지된 보물 없음")
        // RARE CREATURE
        add(TranslationKeys.INFO_RARE_CREATURE, "⑿ %s")
        add(TranslationKeys.INFO_NO_RARE_CREATURE, "⑿ 감지된 희귀 생물 없음")
        // DPS
        add(TranslationKeys.INFO_DPS, "⒀ 초 당 %s 데미지")
        add(TranslationKeys.INFO_NO_DPS, "⒀ N/A")
    }

    private fun addInfoToggleButtons() {
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TIME, "시간")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_WEATHER, "날씨")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_FISHING_POWER, "낚시 힘")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_POSITION, "위치")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DEPTH, "깊이")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_ENEMY_COUNT, "몬스터 수")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_KILL_COUNT, "죽인 횟수")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOON_PHASE, "달의 위상")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_MOVEMENT_SPEED, "이동 속도")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_TREASURE, "보물")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_RARE_CREATURES, "희귀 생물")
        add(TranslationKeys.BUTTON_MESSAGE_TOGGLE_DPS, "DPS")
    }

    override fun addConfigs() {
        addConfigDesc("title", "테라리아 유물들 설정")

        addConfigDesc("section.terrartifacts.client.toml", "테라리아 유물들 클라이언트 설정 파일")
        addConfigDesc("section.terrartifacts.client.toml.title", "테라리아 유물들 클라이언트 설정")

        addConfigDesc("infoButtonLayoutPos", "정보 버튼 배치")
        addConfigDesc("infoButtonLayoutPos.tooltip", "정보 악세서리 토글 버튼 배치")

        addConfigDesc("infoButtonOffsetX", "정보 버튼 X 오프셋")
        addConfigDesc("infoButtonOffsetX.tooltip", "정보 악세서리 토글 버튼 X 오프셋")

        addConfigDesc("infoButtonOffsetY", "정보 버튼 Y 오프셋")
        addConfigDesc("infoButtonOffsetY.tooltip", "정보 악세서리 토글 버튼 Y 오프셋")

        addConfigDesc("section.terrartifacts.server.toml", "테라리아 유물들 서버 설정 파일")
        addConfigDesc("section.terrartifacts.server.toml.title", "테라리아 유물들 서버 설정")

        addConfigDesc("radarDetectDistance", "레이더 감지 거리")
        addConfigDesc("radarDetectDistance.tooltip", "레이더 감지 거리 설정")

        addConfigDesc("treasureDetectDistance", "보물 탐지 거리")
        addConfigDesc("treasureDetectDistance.tooltip", "보물 탐지 거리 설정")

        addConfigDesc("rareCreatureDetectDistance", "Rare Creature Detection Range")
        addConfigDesc("rareCreatureDetectDistance.tooltip", "Define Rare Creature Detection Range")
    }

    override fun addTags() {
        addTag(ModTags.Items.INGOTS_TIN, "주석 주괴")
        addTag(ModTags.Items.INGOTS_SILVER, "은 주괴")
        addTag(ModTags.Items.INGOTS_TUNGSTEN, "텅스텐 주괴")
        addTag(ModTags.Items.INGOTS_PLATINUM, "백금 주괴")
        addTag(ModTags.Items.CURIOS_ACCESSORIES, "악세서리")
    }
}