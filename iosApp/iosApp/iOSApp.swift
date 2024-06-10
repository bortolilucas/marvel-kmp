import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        InitKoin_iosKt.doInitKoinIOS(gifHelper: IOSGifHelper())
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
