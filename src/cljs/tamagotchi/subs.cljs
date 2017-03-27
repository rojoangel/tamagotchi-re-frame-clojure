(ns tamagotchi.subs
    (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]
            [tamagotchi.logic :as logic]))

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
    (if (> hungriness (* logic/max-attribute-value 0.9))
      "#ff0000"                                             ; red
      (if (> hungriness (* logic/max-attribute-value 0.75))
        "#ff9d00"                                           ; orange
        "#00ff00"))))                                       ; green

(re-frame/reg-sub
  :fullness
  (fn [db]
    (:fullness db)))

(re-frame/reg-sub
  :fullness-color
  (fn [query-v _]
    (re-frame/subscribe [:fullness]))
  (fn [fullness]
    (if (> fullness (* logic/max-attribute-value 0.9))
      "#ff0000"                                             ; red
      (if (> fullness (* logic/max-attribute-value 0.75))
        "#ff9d00"                                           ; orange
        "#00ff00"))))                                       ; green

(re-frame/reg-sub
  :happiness
  (fn [db]
    (:happiness db)))

(re-frame/reg-sub
  :happiness-color
  (fn [query-v _]
    (re-frame/subscribe [:happiness]))
  (fn [happiness]
    (if (< happiness (* logic/max-attribute-value 0.1))
      "#ff0000"                                             ; red
      (if (< happiness (* logic/max-attribute-value 0.25))
        "#ff9d00"                                           ; orange
        "#00ff00"))))                                       ; green

(re-frame/reg-sub
  :tiredness
  (fn [db]
    (:tiredness db)))

(re-frame/reg-sub
  :tiredness-color
  (fn [query-v _]
    (re-frame/subscribe [:tiredness]))
  (fn [tiredness]
    (if (> tiredness (* logic/max-attribute-value 0.9))
      "#ff0000"                                             ; red
      (if (> tiredness (* logic/max-attribute-value 0.75))
        "#ff9d00"                                           ; orange
        "#00ff00"))))                                       ; green
