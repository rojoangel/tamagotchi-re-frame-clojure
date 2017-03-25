(ns tamagotchi.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        hungriness (re-frame/subscribe [:hungriness])
        fullness (re-frame/subscribe [:fullness])
        happiness (re-frame/subscribe [:happiness])]
    (fn []
      [:div
       [:div "name: " @name]
       [:div "hungriness: " @hungriness]
       [:div "fullness: " @fullness]
       [:div "happiness: " @happiness]
       ])))
