(ns tamagotchi.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
  :hungriness
  (fn [db]
    (:hungriness db)))

(re-frame/reg-sub
  :fullness
  (fn [db]
    (:fullness db)))

(re-frame/reg-sub
  :happiness
  (fn [db]
    (:happiness db)))