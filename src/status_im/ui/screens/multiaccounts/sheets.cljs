(ns status-im.ui.screens.multiaccounts.sheets
  (:require [status-im.ui.components.list-item.views :as list-item]
            [status-im.ui.components.react :as react]
            [re-frame.core :as re-frame]))

(defn actions-sheet []
  [react/view
   [list-item/list-item {:theme    :action
                         :on-press #(do (re-frame/dispatch [:bottom-sheet/hide])
                                        (re-frame/dispatch [:multiaccounts.create.ui/intro-wizard false]))
                         :icon     :main-icons/add
                         :title    :t/generate-a-new-key}]])
