(ns tamagotchi-web.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        hungriness (re-frame/subscribe [:hungriness])
        fullness (re-frame/subscribe [:fullness])
        happiness (re-frame/subscribe [:happiness])
        tiredness (re-frame/subscribe [:tiredness])
        is-death? (re-frame/subscribe [:is-death?])]
    (fn []
      [:div
       [:div "name: " @name]
       (if (not @is-death?)
         [:img {:src "img/tamagotchi.gif" :height 42 }]
         [:img {:src "img/rip.gif" :height 42 }])
       [:div#hungriness
        [:div#hungriness-label {:style {:float "left"}} "hungriness: "]
        [:div#hungriness-value {:style {:color @(re-frame/subscribe [:hungriness-color])}} @hungriness]]
       [:div#fullness
        [:div#fullness-label {:style {:float "left"}} "fullness: "]
        [:div#fullness-value {:style {:color @(re-frame/subscribe [:fullness-color])}} @fullness]]
       [:div#happiness
        [:div#happiness-label {:style {:float "left"}} "happiness: "]
        [:div#happiness-value {:style {:color @(re-frame/subscribe [:happiness-color])}} @happiness]]
       [:div#tiredness
        [:div#tiredness-label {:style {:float "left"}} "tiredness: "]
        [:div#tiredness-value {:style {:color @(re-frame/subscribe [:tiredness-color])}} @tiredness]]
       [:button {:on-click #(re-frame/dispatch [:feed]) :disabled @is-death?} "Feed"]
       [:button {:on-click #(re-frame/dispatch [:poo]) :disabled @is-death?} "Poo"]
       [:button {:on-click #(re-frame/dispatch [:bed]) :disabled @is-death?} "Bed"]
       [:button {:on-click #(re-frame/dispatch [:play]) :disabled @is-death?} "Play"]
       ])))
