(ns tamagotchi-web.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]
            [tamagotchi-web.logic :as logic]
            [tamagotchi-web.color :as color]))

(re-frame/reg-sub
  :name
  (fn [db]
    (:name db)))

(re-frame/reg-sub
  :hungriness
  (fn [db]
    (:hungriness db)))

(re-frame/reg-sub
  :hungriness-color
  (fn [query-v _]
    (re-frame/subscribe [:hungriness]))
  (fn [hungriness]
    (color/value->color {:type :increasing :val hungriness} #(color/color-map %))))

(re-frame/reg-sub
  :fullness
  (fn [db]
    (:fullness db)))

(re-frame/reg-sub
  :fullness-color
  (fn [query-v _]
    (re-frame/subscribe [:fullness]))
  (fn [fullness]
    (color/value->color {:type :increasing :val fullness} #(color/color-map %))))

(re-frame/reg-sub
  :happiness
  (fn [db]
    (:happiness db)))

(re-frame/reg-sub
  :happiness-color
  (fn [query-v _]
    (re-frame/subscribe [:happiness]))
  (fn [happiness]
    (color/value->color {:type :decreasing :val happiness} #(color/color-map %))))

(re-frame/reg-sub
  :tiredness
  (fn [db]
    (:tiredness db)))

(re-frame/reg-sub
  :tiredness-color
  (fn [query-v _]
    (re-frame/subscribe [:tiredness]))
  (fn [tiredness]
    (color/value->color {:type :increasing :val tiredness} #(color/color-map %))))
