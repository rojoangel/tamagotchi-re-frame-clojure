(ns tamagotchi.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        hungriness (re-frame/subscribe [:hungriness])
        fullness (re-frame/subscribe [:fullness])
        happiness (re-frame/subscribe [:happiness])
        tiredness (re-frame/subscribe [:tiredness])]
    (fn []
      [:div
       [:div "name: " @name]
       [:div "hungriness: " @hungriness]
       [:div "fullness: " @fullness]
       [:div "happiness: " @happiness]
       [:div "tiredness: " @tiredness]
       [:button {:on-click #(re-frame/dispatch [:feed])} "Feed"]
       [:button {:on-click #(re-frame/dispatch [:poo])} "Poo"]
       ])))
