@file:Suppress("unused")

package dev.blendthink.population.ui.extension

import org.jetbrains.compose.web.css.*

// https://developer.mozilla.org/en-US/docs/Web/CSS/text-transform
fun StyleScope.textTransform(transform: TextTransform) {
    property("text-transform", transform.value)
}

enum class TextTransform(val value: String) {
    CAPITALIZE("capitalize"),
    UPPERCASE("uppercase"),
    LOWERCASE("lowercase"),
    NONE("none"),
    FULL_WIDTH("full-width"),
    FULL_SIZE_KANA("full-size-kana"),
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/text-align
fun StyleScope.textAlign(textAlign: TextAlign) = textAlign(textAlign.value)

enum class TextAlign(val value: String) {
    Start("start"),
    End("end"),
    Left("left"),
    Right("right"),
    Center("center"),
    Justify("justify"),
    JustifyAll("justify-all"),
    MatchParent("match-parent"),
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/float
fun StyleScope.float(float: Float) {
    property("float", float.value)
}

enum class Float(val value: String) {
    NONE("none"),
    LEFT("left"),
    RIGHT("right"),
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/cursor
fun StyleScope.cursor(vararg cursors: Cursor) = cursor(cursors.joinToString(", ") { it.value })

enum class Cursor(val value: String) {
    // General
    Auto("auto"),
    Default("default"),
    None("none"),

    // Links & status
    ContextMenu("context-menu"),
    Help("help"),
    Pointer("pointer"),
    Progress("progress"),
    Wait("wait"),

    // Selection
    Cell("cell"),
    Crosshair("crosshair"),
    Text("text"),
    VerticalText("vertical-text"),

    // Drag & drop
    Alias("alias"),
    Copy("copy"),
    Move("move"),
    NoDrop("no-drop"),
    NotAllowed("not-allowed"),
    Grab("grab"),
    Grabbing("grabbing"),

    // Resizing & scrolling
    AllScroll("all-scroll"),
    ColResize("col-resize"),
    RowResize("row-resize"),
    NResize("n Resize"),
    EResize("e Resize"),
    SResize("s Resize"),
    WResize("w Resize"),
    NeResize("ne-resize"),
    NwResize("nw-resize"),
    SeResize("se-resize"),
    SwResize("sw-resize"),
    EwResize("ew-resize"),
    NsResize("ns-resize"),
    NeswResize("nesw-resize"),
    NwseResize("nwse-resize"),

    // Zooming
    ZoomIn("zoom-in"),
    ZoomOut("zoom-out"),
}

// https://developer.mozilla.org/en-US/docs/Web/HTML/Element
fun SelectorsScope.tag(tag: Tag) = type(tag.name)

enum class Tag {
    // Main root
    Html,

    // Document metadata
    Base,
    Head,
    Link,
    Meta,
    Style,
    Title,

    // Sectioning root
    Body,

    // Content sectioning
    Address,
    Article,
    Aside,
    Footer,
    Header,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    Main,
    Nav,
    Section,

    // Text content
    Blockquote,
    Dd,
    Div,
    Dl,
    Dt,
    Figcaption,
    Figure,
    Hr,
    Li,
    Menu,
    P,
    Pre,
    Ul,

    // Inline text semantics
    A,
    Abbr,
    B,
    Bdi,
    Bdo,
    Br,
    Cite,
    Code,
    Data,
    Dfn,
    Em,
    I,
    Kbd,
    Mark,
    Q,
    Rp,
    Rt,
    Ruby,
    S,
    Samp,
    Small,
    Strong,
    Sub,
    Sup,
    Time,
    U,
    Var,
    Wbr,

    // Image and multimedia
    Area,
    Audio,
    Img,
    Map,
    Track,
    Video,

    // Embedded content
    Embed,
    Iframe,
    Object,
    Picture,
    Portal,
    Source,

    // SVG and MathML
    Svg,
    Math,

    // Scripting
    Canvas,
    Noscript,
    Script,

    // Demarcating edits
    Del,
    Ins,

    // Table content
    Caption,
    Col,
    Colgroup,
    Table,
    Tbody,
    Td,
    Tfoot,
    Th,
    Thead,
    Tr,

    // Forms
    Button,
    Datalist,
    Fieldset,
    Form,
    Input,
    Label,
    Legend,
    Meter,
    Optgroup,
    Option,
    Output,
    Progress,
    Select,
    Textarea,

    // Interactive elements
    Details,
    Dialog,
    Summary,

    // Web Components
    Slot,
    Template,
}

// https://developer.mozilla.org/en-US/docs/Web/CSS/transition
fun StyleScope.transition(
    property: String = "all",
    duration: CSSSizeValue<CSSUnit.s> = 0.s,
    timingFunction: AnimationTimingFunction = AnimationTimingFunction.Ease,
    delay: CSSSizeValue<CSSUnit.s> = 0.s,
) {
    property("transition", "$property $duration $delay ${timingFunction.value}")
}
